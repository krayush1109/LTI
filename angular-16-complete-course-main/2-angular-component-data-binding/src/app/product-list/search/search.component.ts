import { Component } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  errorMsg: string = "Image Not found - custom";

  searchText: string = 'Mens Wrist watch';

  updateSearchText(event: any){
      this.searchText = event.target.value;
  }
}
