package notejam

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test that email must have a max size of 75"() {
        when: "the email is greater than 75 characters"
        def invalidEmail = ""
        76.times{ invalidEmail += "a" }
        def user = new User(email: invalidEmail, password: "getrekt")

        then: "validation should fail"
        !user.validate()

        when: "the email is less than 75 characters"
        def validEmail = ""
        74.times{ validEmail += "a" }
        user = new User(email: validEmail, password: "getrekt")

        then: "validation should pass"
        user.validate()
    }

    void "test that password must have a max size of 128"() {
        when: "the password is greater than 75 characters"
        def invalidPassword = ""
        129.times{ invalidPassword += "a" }
        def user = new User(email: "get@rekt.com", password: invalidPassword)

        then: "validation should fail"
        !user.validate()

        when: "the password is less than 127 characters"
        def validPassword = ""
        127.times{ validPassword = "a" }
        user = new User(email: "get@rekt.com", password: validPassword)

        then: "validation should pass"
        user.validate()
    }
}
