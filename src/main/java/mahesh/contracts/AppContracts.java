package mahesh.contracts;

import com.peppermintchain.core.annotations.PMCContract;
import com.peppermintchain.core.annotations.PMCEndPoint;
import com.peppermintchain.core.contracts.PMCContractContext;
import java.util.Map;

@PMCContract
public class AppContracts {

    @PMCEndPoint("testContract")
    public void testContract(PMCContractContext ctx, Map<String,? extends Object> inputData) throws Exception {
	
    }
}
