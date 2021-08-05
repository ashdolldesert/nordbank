import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CleavejsComponent } from './cleavejs.component';

describe('CleavejsComponent', () => {
  let component: CleavejsComponent;
  let fixture: ComponentFixture<CleavejsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CleavejsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CleavejsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
