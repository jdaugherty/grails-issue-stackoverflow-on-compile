# GrailsCompileStatic StackOverflow Example

run `./gradlew compileGroovy` to produce the error

# Example output

        > Configure project :
        Micronaut Support Detected for issue-grails-compile-static
        
        > Task :compileGroovy FAILED
        
        FAILURE: Build failed with an exception.
        
        * What went wrong:
          Execution failed for task ':compileGroovy'.
        > java.lang.StackOverflowError (no error message)
        
        * Try:
        > Run with --stacktrace option to get the stack trace.
        > Run with --info or --debug option to get more log output.
        > Run with --scan to get full insights.
        > Get more help at https://help.gradle.org.
        
        BUILD FAILED in 1s
        5 actionable tasks: 3 executed, 2 up-to-date