#-----------------------------------------------------
MAIN=main
ASCIIDOC=asciidoc -a data-uri
#ASCIIDOC=asciidoc -a icons -a iconsdir=$(ICONSDIR) -a data-uri
DOCTOR=asciidoctor -a data-uri
#ASCIIDOCTOR=asciidoctor
EXT=asc
OUTPUT=.
#SLIDESTYLE=web-2.0
#SLIDESTYLE=neon
SLIDESTYLE=swiss
TEMPLATEDIR=/Users/bruel/dev/asciidoctor-backends/haml/deckjs
IMAGESDIR=/Users/bruel/dev/idm2014/sysml/images
ICONSDIR=/Users/bruel/dev/images/icons
DEP= definitions.txt asciidoc.conf
#-----------------------------------------------------

all: $(MAIN).html $(MAIN).slides.html

%.html: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate HTML'
	$(DOCTOR) -b html5 -a numbered -a imagesdir=$(IMAGESDIR) -a iconsdir=$(ICONSDIR) -a toc -o $@ $<

%.slides.html: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files to generate Deckjs'
	$(DOCTOR) -a slides -T $(TEMPLATEDIR) -b deckjs -a deckjs_transition=horizontal-slide -a deckjs_theme=$(SLIDESTYLE) -a icons -a iconsdir=$(ICONSDIR) -a imagesdir=$(IMAGESDIR) -o $@ $<
