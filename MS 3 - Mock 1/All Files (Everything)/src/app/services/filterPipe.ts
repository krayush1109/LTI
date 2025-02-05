// filter.pipe.ts
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {
//complete missing code
  
  transform(items: any[], searchTerm: string) {
    
    if(searchTerm == ''){
      return items;
    } else {
      const f = items.filter(
        (a)=> a.name.toLowerCase().includes(searchTerm.toLowerCase())
      )

      if(f.length < 1)
        return [];

      return f;
    }
  }

}

// ------- Revise ----------
export class FilterPipe implements PipeTransform {

  transform(items: any[], searchTerm: string){

    if(searchTerm == ''){
      return items;
    } else {
      const filter
    }

  }

}
