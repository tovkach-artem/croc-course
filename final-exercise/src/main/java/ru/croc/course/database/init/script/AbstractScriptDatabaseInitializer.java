package ru.croc.course.database.init.script;

import ru.croc.course.database.datasource.DataSourceProvider;

import java.nio.file.Path;

public abstract class AbstractScriptDatabaseInitializer {

    private final Path pathToScript;

    private final ScriptType scriptType;
    private final DataSourceProvider dataSourceProvider;

    public AbstractScriptDatabaseInitializer(Path pathToScript, ScriptType scriptType, DataSourceProvider dataSourceProvider) {
        this.pathToScript = pathToScript;
        this.scriptType = scriptType;
        this.dataSourceProvider = dataSourceProvider;
    }

    public Path getPathToScript() {
        return pathToScript;
    }

    public DataSourceProvider getDataSourceProvider() {
        return dataSourceProvider;
    }

    public ScriptType getScriptType() {
        return scriptType;
    }

    public abstract void initializeDatabase();
}
