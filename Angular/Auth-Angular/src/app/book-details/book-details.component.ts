// src/app/book-details/book-details.component.ts

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {
  bookId: number | undefined;
  book: { id: number, title: string, author: string } | undefined;

  books = [
    { id: 1, title: 'Book 1', author: 'Author 1', price:'100', publishedOn:'2024-07-19' },
    { id: 2, title: 'Book 2', author: 'Author 2' , price:'200', publishedOn:'2024-07-19'},
    { id: 3, title: 'Book 3', author: 'Author 3' , price:'300', publishedOn:'2024-07-19'},
  ];

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.bookId = +params['id'];
      this.book = this.books.find(book => book.id === this.bookId);
    });
  }
}
