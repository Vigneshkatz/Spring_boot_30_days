export class Posts {
    constructor(public id: number,
        public title: string,
        public excerpt: string,
        public content: string,
        public author: string,
        public published_at: Date,
        public is_published: Date,
        public created_at: Date,
        public updated_at: Date,
        public comments:Comment[]) {

    }

}
