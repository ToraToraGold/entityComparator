import java.lang.reflect.Field

class EntityOps {

    static def overrideAccess(Field... fields){
        fields.each {
            it.setAccessible(true)
        }
    }

    static Map<String,String> fieldMap(def clazz){
        Map<String,String> map = new  HashMap<String,String>()
        clazz.getClass().getDeclaredFields().each {
            it.setAccessible(true)
            map.put(it.get(clazz).getClass().toString(),it.getName())
        }
        map
    }
}
