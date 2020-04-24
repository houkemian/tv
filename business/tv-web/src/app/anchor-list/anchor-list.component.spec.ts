import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnchorListComponent } from './anchor-list.component';

describe('AnchorListComponent', () => {
  let component: AnchorListComponent;
  let fixture: ComponentFixture<AnchorListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnchorListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnchorListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
