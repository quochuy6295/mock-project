export interface IStudent {
  id?: number;
  fullName?: string;
  gender?: string;
  phone_number?: string;
  email?: string;
  birthday?: string;
  school?: string;
  address?: string;
  social_info?: string;
  target?: string;
  status?: string;
  history_transaction?: string;
  source?: string;
  // team_id?: number;
  // user_id?: number;
  // created_date?: string;
}

export class Student implements IStudent {
  constructor(
    public id?: number,
    public full_name?: string,
    public gender?: string,
    public phone_number?: string,
    public email?: string,
    public birthday?: string,
    public school?: string,
    public address?: string,
    public social_info?: string,
    public target?: string,
    public status?: string,
    public history_transaction?: string,
    public source?: string,
    // public team_id?: number,
    // public user_id?: number,
    // public created_date?: string
  ) {}
}
