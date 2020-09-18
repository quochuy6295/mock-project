export interface IUser {
  id?: number;
  name?: string;
  email?: string;
  password?: string;
  team?: any;
  role?: string;
}

export class User implements IUser {
  constructor(
    public id?: number,
    public name?: string,
    public email?: string,
    public password?: string,
    public team?: any,
    public role?: string
  ) {}
}
