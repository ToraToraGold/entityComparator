import java.lang.reflect.Field

class EntityComparator {

    private Set<Object> comparedObjects = new HashSet<Object>()

    def compareEntity(def expected, def actual) {
        assertFieldMap(expected,actual)
        comparedObjects.add(actual)
        actual.getClass().getDeclaredFields().each { actualField ->
            Field expectedField = expected.getClass().getDeclaredField(actualField.getName())

            actualField.setAccessible(true)
            expectedField.setAccessible(true)


            if(expectedField.get(expected) == null) {
                assert actualField.get(actual) == null
            } else
            switch (TypeId.getType(actualField.get(actual))){
                case "wrapper":
                    assert expectedField.get(expected) == actualField.get(actual)
                    break;
                case "collection":
                    assert expectedField.get(expected) as Set == actualField.get(actual) as Set
                    break;
                case "map":
                    assert expectedField.get(expected) as Map == actualField.get(actual) as Map
                    break;
                default:
                    if(!comparedObjects.contains(actualField.get(actual)))
                        compareEntity(expectedField.get(expected),actualField.get(actual))
                    break;
            }
        }
    }

    def assertFieldMap(def expected, def actual){
        assert fieldMap(expected) == fieldMap(actual)
    }

    Map<String,String> fieldMap(def clazz){
        Map<String,String> map = new  HashMap<String,String>()
        clazz.getClass().getDeclaredFields().each {
            it.setAccessible(true)
            map.put(it.get(clazz).getClass().toString(),it.getName())
        }
        map
    }
}
