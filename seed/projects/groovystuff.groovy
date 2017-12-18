job('groovystuff-seed') {
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
        gradle {
            tasks('clean')
            tasks('build')
            useWrapper(true)
            makeExecutable(true)
        }
        dsl {
            external('jobs/groovystuff/*.groovy')
            removeAction('DISABLE')
            removeViewAction('DELETE')
            ignoreExisting(false)
            additionalClasspath([
                    'src/main/groovy', 'src/main/resources', 'build/lib/*.jar'
            ].join("\n"))
        }
    }
}
