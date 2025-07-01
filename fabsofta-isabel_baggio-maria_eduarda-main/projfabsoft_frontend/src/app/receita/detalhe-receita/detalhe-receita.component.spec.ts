import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalheReceita } from './detalhe-receita.component';

describe('DetalheReceita', () => {
  let component: DetalheReceita;
  let fixture: ComponentFixture<DetalheReceita>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetalheReceita]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetalheReceita);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
