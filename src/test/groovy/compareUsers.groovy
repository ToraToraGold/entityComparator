import java.lang.reflect.Field

def a = new UserTwo('ddd','sss',13)
def b = new UserThree('ddd','sss',13)

Set<Class<?>> defaultTypes(){
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
    set.add(List.class)
    set
}

def compare(def a, def b) {
    for (Field f : a.getClass().getDeclaredFields()) {
        for (Field g : b.getClass().getDeclaredFields()) {
            if (f.getName() == g.getName()) {
                f.setAccessible(true)
                g.setAccessible(true)
                if(defaultTypes().contains(f.get(a).getClass())){
                    assert f.get(a) == g.get(b)
                }
                else{
                    compare(f.get(a),g.get(b))
                }
            }
        }
    }
}

compare(a,b)
