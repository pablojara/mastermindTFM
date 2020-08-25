package es.urjccode.mastercloudapps.adcs.mastermind.models.DAO;

import es.urjccode.mastercloudapps.adcs.mastermind.models.ProposedCombination;

class ProposedCombinationDAO extends CombinationDAO {

	ProposedCombinationDAO(ProposedCombination proposedCombination) {
		super(proposedCombination);
	}

	ProposedCombination getProposedCombination() {
		return (ProposedCombination) this.combination;
	}

}
