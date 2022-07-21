import it.menghini.davide.JTris.Model.DefaultTrisCell;
import it.menghini.davide.JTris.Model.TrisCell;
import org.junit.jupiter.api.Test;

        ;import static org.junit.jupiter.api.Assertions.assertEquals;


public class TrisCellTest {

    @Test
    public void valueTest(){
        TrisCell<DummyValues> t = new DefaultTrisCell<>(DummyValues.UNO);
        t.setValue(DummyValues.UNO);
        assertEquals(t.getValue(),DummyValues.UNO);
        t.setValue(DummyValues.DUE);
        assertEquals(t.getValue(),DummyValues.DUE);
    }




    private enum DummyValues{
        UNO,
        DUE;
    }
}



