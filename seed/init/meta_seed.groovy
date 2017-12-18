
job('meta-seed') {
    triggers {
        githubPush()
    }
    scm {
        git {
            remote {
                github('h2m/build-scripts')
            }
            branch('master')
        }
    }
    steps {
        gradle("clean build")
        dsl {
            external('projects/*.groovy')
            removeAction('DISABLE')
            removeViewAction('DELETE')
            ignoreExisting(false)
            additionalClasspath([
                    'src/main/groovy', 'src/main/resources', 'build/lib/*.jar'
            ].join("\n"))
        }
    }
}
