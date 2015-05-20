
import spock.lang.Specification
import spock.lang.Unroll
import spock.lang.Ignore

class CalculateComplexitySpec extends Specification {

    @Unroll
    void "Make sure password length is as input with valid input: #length"() {
        expect:
        Utils.randomString(length).length() == length

        where:
        length << [1, 5, 10]
    }

    @Ignore
    @Unroll
    void "Make sure password length robust against invalid input: #input"() {
        expect:
        Utils.randomString(input)?.length() == 42

        where:
        input << [null, 0, -5]
    }

    @Unroll
    void "Test calculating complexity is correct: password='#password' - #comment"() {
        expect:
        Utils.calculateComplexity(password) == expectedComplexity

        where:
        password    | expectedComplexity    | comment
        ""          | 0                     | "Empty string"
        "a"         | 5                     | "Only one lower case character"
        "ab"        | 6                     | "Lower case character and one subsequent"
        "aba"       | 7                     | "Lower case character and 2 subsequent character"
        "1"         | 5                     | "Only a digit"
        "12"        | 6                     | "A digit and a subsequent one"
        "A"         | 5                     | "One upper case char"
        "AB"        | 6                     | "Two upper case char"
        "#"         | 5                     | "Special character"
        "#&"        | 10                    | "Two special character"
    }

    void "Test calculating complexity is robust"() {
        when:
        Utils.calculateComplexity(null)

        then:
        thrown(NullPointerException)
    }
}
