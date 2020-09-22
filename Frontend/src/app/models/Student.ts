export interface IStudent {
  id?: number;
  fullName?: string;
  gender?: string;
  phoneNumber?: string;
  email?: string;
  birthday?: string;
  school?: string;
  address?: string;
  socialInfo?: string;
  target?: string;
  status?: string;
  historyTransaction?: string;
  source?: string;
  teamId?: number;
  userId?: number;
  createdDate?: string;
}

export class Student implements IStudent {
  constructor(
    public id?: number,
    public fullName?: string,
    public gender?: string,
    public phoneNumber?: string,
    public email?: string,
    public birthday?: string,
    public school?: string,
    public address?: string,
    public socialInfo?: string,
    public target?: string,
    public status?: string,
    public historyTransaction?: string,
    public source?: string,
    public teamId?: number,
    public userId?: number,
    public createdDate?: string
  ) {}
}
