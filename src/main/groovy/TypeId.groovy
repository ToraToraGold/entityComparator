class TypeId {

    static Set<Class<?>> defaultTypes(){
        Set<Class<?>> set = new HashSet<Class<?>>()
        set.add(Boolean.class)
        set.add(Character.class)
        set.add(Byte.class)
        set.add(Short.class)
        set.add(Integer.class)
        set.add(Long.class)
        set.add(Float.class)
        set.add(Double.class)
        set.add(String.class)
        set
    }

    static def getType(Object o) {
        switch (o) {
            case Collection:
                "collection"
                break;
            case Map:
                "map"
                break;
            default:
                if(defaultTypes().contains(o.getClass())) "wrapper"
        }
    }
}
