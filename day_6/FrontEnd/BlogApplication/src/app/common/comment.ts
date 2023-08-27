export class Comment {
    
    constructor(
        public id: number,
        public name: string,
        public email: string,
        public comment: string,
        public createdAt:Date,
        public updatedAt:Date,
    ){

    }

}
