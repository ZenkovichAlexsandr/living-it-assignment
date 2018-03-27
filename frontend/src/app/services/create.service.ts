import { Observable } from 'rxjs/Observable';

export abstract class CreateService<T> {
  abstract create(formData: FormData): Observable<T>;
}
