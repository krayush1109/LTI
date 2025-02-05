export interface Room {

    id?: number,
    name: string,
    floor: string,
    capacity: number,
    lastInspection: Date,
    status: string,

    [key: string]: any

}