package groovystuff

import javaposse.jobdsl.dsl.DslFactory

DslFactory dsl = this

dsl.job("job-dsl-simple-job"){
    steps{
        shell('echo "Hello World"')
    }
}