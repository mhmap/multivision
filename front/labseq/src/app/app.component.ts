import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { LabseqService } from './services/labseq-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class AppComponent {
  title = 'Labseq Calculator';
  inputValue = 0;
  result = '';
  isLoading = false;
  errorMessage = '';

  constructor(private labseqService: LabseqService) {}

  calculate(): void {
    this.resetState();

    if (!this.isValidInput()) {
      this.errorMessage = 'Please enter a non-negative integer';
      return;
    }

    this.isLoading = true;
    this.labseqService.getLabseq(this.inputValue).subscribe({
      next: response => {
        this.result = response;
        this.isLoading = false;
      },
      error: err => {
        this.errorMessage = `Error: ${err.status} - ${err.statusText || 'Unknown error'}`;
        this.isLoading = false;
      }
    });
  }

  private resetState(): void {
    this.result = '';
    this.errorMessage = '';
  }

  private isValidInput(): boolean {
    return Number.isInteger(this.inputValue) && this.inputValue >= 0;
  }
}
