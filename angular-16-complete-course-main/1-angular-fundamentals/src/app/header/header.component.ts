import { Component } from "@angular/core";

@Component({
    selector:'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css']
})
export class HeaderComponent{
    h_title = 'My new custom header';

    arr = [11, 22, 33, 44, 55];

}