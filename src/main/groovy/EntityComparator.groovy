import java.lang.reflect.Field

class EntityComparator {

    private Set<Object> comparedObjects = new HashSet<Object>()

    def compareEntity(def expected, def actual) {
        assertFieldMap(expected,actual)
        comparedObjects.add(actual)
        expected.getClass().getDeclaredFields().each { expectedField ->
            Field actualField = actual.getClass().getDeclaredField(expectedField.getName())
            EntityOps.overrideAccess(actualField,expectedField)

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
            }
        }
    }

    private def assertFieldMap(def expected, def actual){
        assert EntityOps.fieldMap(expected) == EntityOps.fieldMap(actual)
    }

}
