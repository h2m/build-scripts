package groovystuff

import javaposse.jobdsl.dsl.DslFactory

DslFactory dsl = this


dsl.listView('Seeds') {
	jobs {
		regex('.*-seed')
	}
	columns defaultColumns()
}

private Closure defaultColumns() {
	return {
		status()
		name()
		lastSuccess()
		lastFailure()
		lastBuildConsole()
		buildButton()
	}
}