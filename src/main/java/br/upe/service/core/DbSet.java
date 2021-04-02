package br.upe.service.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbSet<T> implements IDbSet<T> {

    private Connection conn;
    private Class<T> type;
    private String tableName;

    public DbSet(Connection databaseConnection, Class<T> type) {
        conn = databaseConnection;
        this.type = type;
        tableName = type.getAnnotation(Table.class).name();
    }

    @Override
    public T Find(Object id) {
        StringBuilder commandBuilder = new StringBuilder();
        commandBuilder.append("SELECT * FROM " + tableName + " WHERE id=" + id.toString());
        String command = commandBuilder.toString();
        try {
            ResultSet queryResult = conn.createStatement().executeQuery(command);
            queryResult.next();
            Object object = createObjectFromQuery(queryResult);            
            return (T) object;
        } catch (SQLException e) {
            return null;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> ToArray() {
        String command = "SELECT * FROM " + tableName;
        List<T> list = null;
        try {
            ResultSet queryResult = conn.createStatement().executeQuery(command);
            list = new ArrayList<T>();
            while(queryResult.next())
            {
                list.add(createObjectFromQuery(queryResult));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(T object) {
        Field[] fields = type.getDeclaredFields();
        StringBuilder command = new StringBuilder();
        command.append("UPDATE " + tableName + " SET ");
        String rowId = "";
        for(int i = 0; i< fields.length; i++){
            String columnName = fields[i].getAnnotation(Column.class).name();
            String getMethodName = "get" + capitalize(fields[i].getName());
            Method method;
            try {
                method = object.getClass().getMethod(getMethodName);
                String fieldValue =  method.invoke(object).toString();
                if (columnName.equals("id"))
                {
                    rowId = fieldValue;
                    continue;
                }
                command.append(columnName + " = '" +  fieldValue + "'");
                if (i < (fields.length - 1)){
                    command.append(", ");
                }
            } catch (NoSuchMethodException | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        command.append("WHERE id=" + rowId);
        try {
            PreparedStatement statement = conn.prepareStatement(command.toString());
            int changedRows = statement.executeUpdate();
            return changedRows > 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    private String capitalize(String fieldName) {
        return (fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
    }

    @Override
    public T Create(T object) {
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        Field[] types = type.getDeclaredFields();
        for (int i = 0; i < types.length; i++){
            String columnName = types[i].getAnnotation(Column.class).name();
            if (columnName.equals("id")) {
                continue;
            }
            columns.append(columnName);
            String getMethodName = "get" + capitalize(types[i].getName());
            try {
                Method method = object.getClass().getMethod(getMethodName);
                values.append("'" + method.invoke(object).toString() + "'");
            } catch (NoSuchMethodException | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (i < (types.length - 1))
            {
                columns.append(",");
                values.append(",");
            }
        }
        String createCommand = "INSERT INTO " + tableName + "(" + columns.toString() + ") VALUES(" + values.toString() + ");";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(createCommand, new String[] {"id"});
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) return null;
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                Method method = object.getClass().getMethod("setId", int.class);
                method.invoke(object, rs.getInt(1));
            }
            return object;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean Delete(Object id) {
        // TODO Auto-generated method stub
        String command = "DELETE FROM " + tableName + " WHERE id=" + id.toString();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(command);
            int nChangedRows = preparedStatement.executeUpdate();
            return nChangedRows > 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    private T createObjectFromQuery(ResultSet queryResult)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, SQLException {
        Object object = type.getDeclaredConstructor().newInstance();
        for (Field field : type.getDeclaredFields()) {
            String columnName = field.getAnnotation(Column.class).name();
            String fieldName = field.getName();
            String setMethodName = "set" + capitalize(fieldName);
            Method method = object.getClass().getMethod(setMethodName, field.getType());
            if (field.getType() == int.class) {
                method.invoke(object, Integer.parseInt(queryResult.getString(columnName)));
            } else {
                method.invoke(object, queryResult.getString(columnName));
            }
        }
        return (T) object;
    }

}
