import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { map, take } from "rxjs/operators";
import { AuthService } from "../auth.service";


@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        const check = this.authService.isLoggedIn();
        if (check) {
            return true;
        }
        this.router.navigate(['/auth'])
        return false;
        
        // return this.authService.user.pipe(
        //     take(1),
        //     map(user => {
        //     const isAuth =  !!user
        //     if (isAuth)
        //         return true;
        //     return this.router.createUrlTree(['/auth']);
        // }));
    }

    constructor(private router : Router, private authService: AuthService){}
}