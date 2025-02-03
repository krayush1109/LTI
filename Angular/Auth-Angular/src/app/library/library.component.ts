// src/app/library/library.component.ts

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {
  books = [
    { id: 1, title: 'Book 1', author: 'Author 1',price:'100',publishedOn:'2024-07-19' },
    { id: 2, title: 'Book 2', author: 'Author 2' ,price:'200',publishedOn:'2024-07-19'},
    { id: 3, title: 'Book 3', author: 'Author 3' ,price:'300',publishedOn:'2024-07-19'},
  ];

  constructor() { }

  ngOnInit(): void {
  }
}
