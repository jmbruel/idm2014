package org.gemoc.agro.activitiesDSL

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import org.gemoc.agro.activities.k3dsa.Context
import org.gemoc.agro.activitiesDSL.Model
import org.gemoc.agro.activitiesDSL.ResourceKind
import org.gemoc.agro.activitiesDSL.Culture
import org.gemoc.agro.activitiesDSL.ExploitationActivity
import org.gemoc.agro.activitiesDSL.Predicate
import org.gemoc.agro.activitiesDSL.NoRain
import org.gemoc.agro.activitiesDSL.TempOfTheDay
import org.gemoc.agro.activitiesDSL.DelaySinceActivy
import org.gemoc.agro.activitiesDSL.GrainIs
import org.gemoc.agro.activitiesDSL.Date

import static extension org.gemoc.agro.activitiesDSL.ExploitationActivityAspect.*


@Aspect(className=ExploitationActivity)
class ExploitationActivityAspect {
	def public void start (Context context) { 
		println ("start "+_self.name)
	}
}




