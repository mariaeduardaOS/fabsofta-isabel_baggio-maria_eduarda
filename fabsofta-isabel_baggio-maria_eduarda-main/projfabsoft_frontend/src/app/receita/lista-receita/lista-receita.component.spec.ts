import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaReceita } from './lista-receita.component';

describe('ListaReceita', () => {
  let component: ListaReceita;
  let fixture: ComponentFixture<ListaReceita>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaReceita]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaReceita);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
