export interface ITeam {
  id?: number;
  name?: string;
  teamLeadId?: number;
}

export class Team implements ITeam {
  constructor(
    public id?: number,
    public name?: string,
    public teamLeadId?: number
  ) {}
}
