package notejam

class Note {

    String name
    String text
    Date created_at
    Date updated_at

    static belongsTo = [Pad, User]

    static constraints = {
        name maxSize: 100
    }

    static mapping = {
        text type: 'text'
        table 'notes'
    }
}
