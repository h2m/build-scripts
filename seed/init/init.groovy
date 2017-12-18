import javaposse.jobdsl.dsl.DslScriptLoader
import javaposse.jobdsl.plugin.JenkinsJobManagement

def seeds = new File('/usr/share/jenkins/seeds/')
def jobManagement = new JenkinsJobManagement(System.out, [:], new File('.'))

new DslScriptLoader(jobManagement).with {
	seeds.eachFileRecurse (groovy.io.FileType.FILES) { file ->
  		runScript(file.text)
	}
}
