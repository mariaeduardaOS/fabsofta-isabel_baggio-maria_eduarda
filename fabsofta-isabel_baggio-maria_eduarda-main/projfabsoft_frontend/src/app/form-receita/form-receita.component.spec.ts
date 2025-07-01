import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormReceita } from './form-receita.component';

describe('FormReceita', () => {
  let component: FormReceita;
  let fixture: ComponentFixture<FormReceita>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormReceita]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormReceita);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
