package notejam

class Pad {

    String name

    static belongsTo = User
    static hasMany = [notes: Note]

    static constraints = {
      name maxSize: 100
    }

    static mapping = {
      table 'pads'
    }
}
