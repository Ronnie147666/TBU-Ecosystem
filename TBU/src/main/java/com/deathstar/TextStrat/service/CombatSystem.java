package com.deathstar.TextStrat.service;

import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;
import com.deathstar.TextStrat.domain.Emperor;
import com.deathstar.domain.Unit;

@Service
public class CombatSystem {

	public void fight(Emperor attacker, Emperor defender) {

		if (attacker.getUnits() != null && !attacker.getUnits().isEmpty()) {
			BoardService.printer("");
			BoardService.printer(attacker.getName() + "'s turn");
		}

		attacker.getUnits().forEach(u -> {

			Unit target = getTarget(defender.getUnits());

			if (target == null) {
				return;
			}

			int pDmg = u.getpAtt() > target.getpDef() ? u.getpAtt() - target.getpDef() : 0;
			int mDmg = u.getmAtt() > target.getmDef() ? u.getmAtt() - target.getmDef() : 0;

			for (int i = 1; i <= u.getGroup(); i++) {

			    int tempHp = Math.max(target.getHp() - (pDmg + mDmg), 0);
				target.setHp(tempHp);
				BoardService.printer((WarRoom.unitNaming(u, String.valueOf(i)) + " attacks for " + String.valueOf(pDmg)
						+ ":PD and " + String.valueOf(mDmg) + ":MD ---> "
						+ WarRoom.unitNaming(target, String.valueOf("1")) + "/HP:" + target.getHp()));

				bury(defender.getUnits());
				if (target.getGroup() == 0) {
					target = getTarget(defender.getUnits());
					if (target == null) {
						break;
//						continue;
//					} else {
//						break;
					}
				}
			}
		});

		if (defender.getUnits() != null && !defender.getUnits().isEmpty()) {
			attacker.getUnits().forEach(u -> {
				if (u.getHeal() > 0) {
					heal(attacker.getUnits(), u);
				}
			});
		}
	}

	public void heal(List<Unit> unitsToHeal, Unit healer) {

		unitsToHeal.forEach(u -> {

			for (int i = 1; i <= u.getGroup(); i++) {

				if (u.getHp() != u.getMaxHp() && u.getHp() + healer.getHeal() > u.getMaxHp()) {
					
					BoardService.printer((WarRoom.unitNaming(healer, String.valueOf(i)) + " heals "
							+ WarRoom.unitNaming(u, String.valueOf("1")) + " for " + (u.getMaxHp() - u.getHp())
							+ " HP --> " + WarRoom.unitNaming(u, String.valueOf("1")) + "/HP:" + u.getMaxHp()));
					
					u.setHp(u.getMaxHp());
				} else if (u.getHp() != u.getMaxHp()) {
					BoardService.printer((WarRoom.unitNaming(healer, String.valueOf(i)) + " heals "
							+ WarRoom.unitNaming(u, String.valueOf("1")) + " for " + healer.getHeal() + " HP --> "
							+ WarRoom.unitNaming(u, String.valueOf("1")) + "/HP:" + (u.getHp() + healer.getHeal())));
					
					u.setHp(u.getHp() + healer.getHeal());
				}
			}
		});

	}

	public void bury(List<Unit> unitsToBury) {

		unitsToBury.stream().forEach(u -> {

			if (u.getHp() <= 0) {
				u.setGroup(u.getGroup() - 1);
				u.setHp(u.getMaxHp());
			}
			if (u.getGroup() == 0) {
				BoardService.printer((WarRoom.unitNaming(u, String.valueOf("0")) + " dies"));
			}
		});

		unitsToBury.removeIf(u -> u.getGroup() == 0);

	}

	public Unit getTarget(List<Unit> unitList) {

		return unitList.stream().min(Comparator.comparing(Unit::getHp)).orElse(null);

	}

}
