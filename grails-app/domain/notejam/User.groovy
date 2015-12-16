package notejam

class User {

    String email
    String password

    static hasMany = [pads: Pad, notes: Note]

    static constraints = {
        email maxSize: 75
        password maxSize: 128
    }

    static mapping = {
      table 'users'
    }
}
