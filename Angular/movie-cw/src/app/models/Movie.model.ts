export interface Movie {
    id:number;
    title: string;
    director: string;
    year: number;
    [key : string] : any
  }