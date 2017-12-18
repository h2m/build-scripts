job('groovystuff') {
    triggers {
        githubPush()
    }
    scm {
        git {
            remote {
                github('h2m/groovystuff')
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
    }
}