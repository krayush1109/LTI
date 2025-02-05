
import { FilterPipe } from "src/app/services/filterPipe";



describe('FilterPipe', () => {
  let pipe: FilterPipe;

  beforeEach(() => {
    pipe = new FilterPipe();
  });

  it('should create an instance of FilterPipe', () => {
    expect(pipe).toBeTruthy();
  });



  it('should return the original array if no search term is provided', () => {
    const items = [{ name: 'John' }, { name: 'Jane' }];
    const result = pipe.transform(items, '');
    expect(result).toEqual(items);
  });

  it('should filter items based on the search term', () => {
    const items = [
      { name: 'John' },
      { name: 'Jane' },
      { name: 'Doe' },
      { name: 'Smith' }
    ];
    const searchTerm = 'jo';
    const result = pipe.transform(items, searchTerm);
    expect(result).toEqual([{ name: 'John' }]);
  });

  it('should be case insensitive when filtering', () => {
    const items = [
      { name: 'John' },
      { name: 'Jane' },
      { name: 'Doe' },
      { name: 'Smith' }
    ];
    const searchTerm = 'JANE';
    const result = pipe.transform(items, searchTerm);
    expect(result).toEqual([{ name: 'Jane' }]);
  });

  it('should return an empty array if no items match the search term', () => {
    const items = [
      { name: 'John' },
      { name: 'Jane' },
      { name: 'Doe' }
    ];
    const searchTerm = 'xyz';
    const result = pipe.transform(items, searchTerm);
    expect(result).toEqual([]);
  });
});