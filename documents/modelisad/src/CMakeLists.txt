INCLUDE_DIRECTORIES(
  ${CMAKE_SOURCE_DIR}/src
  ${VLE_INCLUDE_DIRS}
  ${Boost_INCLUDE_DIRS})

LINK_DIRECTORIES(
  ${VLE_LIBRARY_DIRS}
  ${Boost_LIBRARY_DIRS})

ADD_LIBRARY(ResourceManager SHARED ResourceManager.cpp)
TARGET_LINK_LIBRARIES(ResourceManager
  ${VLE_LIBRARIES}
  ${Boost_LIBRARIES})
INSTALL(TARGETS ResourceManager
  RUNTIME DESTINATION lib
  LIBRARY DESTINATION lib
  ARCHIVE DESTINATION lib)
  
ADD_LIBRARY(OS_semis SHARED OS_semis.cpp)
TARGET_LINK_LIBRARIES(OS_semis
  ${VLE_LIBRARIES}
  ${Boost_LIBRARIES})
INSTALL(TARGETS OS_semis
  RUNTIME DESTINATION lib
  LIBRARY DESTINATION lib
  ARCHIVE DESTINATION lib)

ADD_LIBRARY(OS_recolte SHARED OS_recolte.cpp)
TARGET_LINK_LIBRARIES(OS_recolte
  ${VLE_LIBRARIES}
  ${Boost_LIBRARIES})
INSTALL(TARGETS OS_recolte
  RUNTIME DESTINATION lib
  LIBRARY DESTINATION lib
  ARCHIVE DESTINATION lib)

ADD_LIBRARY(OS_defaut SHARED OS_defaut.cpp)
TARGET_LINK_LIBRARIES(OS_defaut
  ${VLE_LIBRARIES}
  ${Boost_LIBRARIES})
INSTALL(TARGETS OS_defaut
  RUNTIME DESTINATION lib
  LIBRARY DESTINATION lib
  ARCHIVE DESTINATION lib)
 
ADD_LIBRARY(Decision SHARED Decision.cpp ext/decision/Activities.cpp
  ext/decision/Activities.hpp ext/decision/Activity.cpp
  ext/decision/Activity.hpp ext/decision/Agent.cpp ext/decision/Agent.hpp
  ext/decision/Facts.hpp ext/decision/KnowledgeBase.cpp
  ext/decision/KnowledgeBase.hpp ext/decision/Library.cpp
  ext/decision/Library.hpp ext/decision/Plan.cpp ext/decision/Plan.hpp
  ext/decision/PrecedenceConstraint.cpp ext/decision/PrecedenceConstraint.hpp
  ext/decision/PrecedencesGraph.cpp ext/decision/PrecedencesGraph.hpp
  ext/decision/Predicates.cpp ext/decision/Predicates.hpp ext/decision/Rule.hpp
  ext/decision/Rules.cpp ext/decision/Rules.hpp ext/decision/Table.hpp)

TARGET_LINK_LIBRARIES(Decision
  ${VLE_LIBRARIES}
  ${Boost_LIBRARIES})
INSTALL(TARGETS Decision
  RUNTIME DESTINATION lib
  LIBRARY DESTINATION lib
  ARCHIVE DESTINATION lib)

ADD_LIBRARY(StadePhenologique SHARED StadePhenologique.cpp)
TARGET_LINK_LIBRARIES(StadePhenologique
  ${VLE_LIBRARIES}
  ${Boost_LIBRARIES})
INSTALL(TARGETS StadePhenologique
  RUNTIME DESTINATION lib
  LIBRARY DESTINATION lib
  ARCHIVE DESTINATION lib)  
