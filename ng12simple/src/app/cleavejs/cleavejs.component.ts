import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cleavejs',
  templateUrl: './cleavejs.component.html',
  styleUrls: ['./cleavejs.component.scss']
})
export class CleavejsComponent implements OnInit {

  dateOption = {
    date: true,
    datePattern: ['Y', 'm', 'd'],
  };

  creditcardOption = {
    creditcard: true,
    numericOnly: true,
    delimiter: ' ',
    blocks: [4, 4, 4, 4],
  };

  upperOption = {
    uppercase: true,
    blocks: [9999]
  };

  numberOption = {
    numericOnly: true,
    blocks: [9999],
  };

  thousandOption = {
    numeral: true,
    numeralThousandsGroupStyle: 'thousand',
  };

  dateDotOption = {
    date: true,
    delimiter: '.',
    datePattern: ['Y', 'm', 'd'],
  };

  numeric4Option = {
    numeral: true,
    numeralDecimalMark: ',',
    delimiter: '.'
  };

  dollarOption = {
      numeral: true,
      prefix: '$'
  };

  format3332Option = {
	  uppercase: true,
    delimiters: ['.', '.', '-'],
    blocks: [3, 3, 3, 2]
  };

 ufoPrefixOption = {
    uppercase: true,
    delimiter: '',
    prefix: 'UFO',
    blocks: [3, 6] // or [9]
  };

 vatOption = {
    numericOnly: true,
    delimiter: '.',
    prefix: 'BE',
    blocks: [5, 3, 3]
  };

  deletemeOption = {
	uppercase: true,
    delimiter: '-',
    blocks: [6, 2, 3, 3]
  };

  multipleOption = {
    uppercase: true,
    delimiters: [' ', '|', ' ', ' ', '|', ' ', ' ', '|', ' '],
    blocks: [3, 0, 0, 3, 0, 0, 3, 0, 0, 3, 0]
  };

  constructor() { }

  ngOnInit(): void {
  }

}
