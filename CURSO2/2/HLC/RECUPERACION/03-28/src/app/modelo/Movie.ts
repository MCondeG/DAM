export class Movie {

    constructor(public vote_count: number,
        public id: number,
        public video: boolean,
        public vote_average: number,
        public title: string,
        public popularity: number,
        public poster_path: string,
        public backdrop_path: string,
        public adult: boolean,
        public overview: string,
        public release_date: string) {
    }

    public static createFromJsonObject(jsonObject: any): Movie {
        let movie: Movie = new Movie(jsonObject['vote_count'],
            jsonObject['id'],
            jsonObject['video'],
            jsonObject['vote_average'],
            jsonObject['title'],
            jsonObject['popularity'],
            jsonObject['poster_path'],
            jsonObject['backdrop_path'],
            jsonObject['adult'],
            jsonObject['overview'],
            jsonObject['release_date']);
        return movie;
    }

    public getJsonObject(): any {
        let jsonObject: any = {};
        jsonObject['vote_count'] = this.vote_count;
        jsonObject['id'] = this.id;
        jsonObject['video'] = this.video;
        jsonObject['vote_average'] = this.vote_average;
        jsonObject['title'] = this.title;
        jsonObject['popularity'] = this.popularity;
        jsonObject['poster_path'] = this.poster_path;
        jsonObject['backdrop_path'] = this.backdrop_path;
        jsonObject['adult'] = this.adult;
        jsonObject['overview'] = this.overview;
        jsonObject['release_date'] = this.release_date;

        return jsonObject;
    }
}