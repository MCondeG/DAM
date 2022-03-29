export class Movie {

    constructor(
        public id: number,
        public title: string,
        public release_date: string,
        public vote_average: number,
        public poster_path: string) {}

    public static createFromJsonObject(jsonObject: any): Movie {
        let movie: Movie = new Movie(
            jsonObject['id'],
            jsonObject['title'],
            jsonObject['release_date'],
            jsonObject['vote_average'],
            jsonObject['poster_path']);

        return movie;
    }

    public getJsonObject(): any {
        let jsonObject: any = {};
        jsonObject['id'] = this.id;
        jsonObject['title'] = this.title;
        jsonObject['release_date'] = this.release_date;
        jsonObject['vote_average'] = this.vote_average;
        jsonObject['poster_path'] = this.poster_path;

        return jsonObject;
    }
}