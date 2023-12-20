package pt.upt.ei.lp.db;

import org.eclipse.persistence.descriptors.ClassExtractor;
import org.eclipse.persistence.sessions.Session;

public class UtilizadorClassExtractor extends ClassExtractor {
    
	@Override
    public Class<?> extractClassFromRow(org.eclipse.persistence.sessions.Record databaseRow, Session session) {
        if (databaseRow.containsKey("CLIENT_SPECIFIC")) {
            return Cliente.class;
        
        } else if (databaseRow.containsKey("VENDEDOR_SPECIFIC")) {
            return VendedorStand.class;
        } else {
            return Utilizador.class; // this should never happen
        }
    }
}

