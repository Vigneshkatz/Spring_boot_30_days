import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterSortingComponent } from './filter-sorting.component';

describe('FilterSortingComponent', () => {
  let component: FilterSortingComponent;
  let fixture: ComponentFixture<FilterSortingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FilterSortingComponent]
    });
    fixture = TestBed.createComponent(FilterSortingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
